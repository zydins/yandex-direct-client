package ru.cultserv.adv.yandex.direct.v5.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import ru.cultserv.adv.yandex.direct.v5.models.util.Format;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Json {

	private static final ObjectMapper MAPPER = createMapper();
	private static final ObjectMapper WRITE_MAPPER = new ObjectMapper();

	private static ObjectMapper createMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.registerModule(new JodaModule());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		mapper.setDateFormat(df);
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

		return mapper;
	}
	
	public static ObjectMapper mapper() {
		return MAPPER;
	}
	
	public static JsonNode toJson(Object obj) {
		return MAPPER.valueToTree(obj);
	}
	
	public static <T> T fromJson(JsonNode json, Class<T> result_class) {
		try {
			return MAPPER.treeToValue(json, result_class);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static <T> T parse(String json, TypeReference<T> tr, boolean flatten) {
		try {
			return MAPPER.readValue(json, tr);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static <T> T parse(String json, Class<T> result_class, boolean flatten) {
		try {
			json = resolve(json, flatten);
			return mapper().readValue(json, result_class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T parse(String json, Type type, boolean flatten) {
		try {
			json = resolve(json, flatten);
			return mapper().readValue(json, mapper().constructType(type));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static String resolve(String json, boolean flatten) {
		if (!flatten) {
			return json;
		}
		try {
			Map<String, Object> o = mapper().readValue(json, new TypeReference<Map<String, Object>>() {});
			if (o.keySet().size() != 1) {
				throw new IllegalStateException("Wrong number of keys");
			}
			String key = o.keySet().iterator().next();
			return mapper().writeValueAsString(o.get(key));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String convertFrom(String body, Format format) {
		try {
			if (format == Format.TSV) {
//				int i = body.indexOf('\n');
//				String name = body.substring(0, i);
//				body = body.substring(i, body.length());
//				i = body.lastIndexOf('\n');
//				body = body.substring(0, i);
				CSVParser parser = new CSVParser(new StringReader(body),
						CSVFormat.newFormat('\t').withRecordSeparator('\n').withQuote('"').withIgnoreEmptyLines(false)
								.withFirstRecordAsHeader());
				List<Map<String, String>> maps = parser.getRecords().stream()
						.map(CSVRecord::toMap)
						.collect(Collectors.toList());
				Map<String, Object> result = new HashMap<>();
//				result.put("Name", name);
				result.put("Entries", maps);
				Map<String, Object> toWrite = new HashMap<>();
				toWrite.put("result", result);
				return WRITE_MAPPER.writeValueAsString(toWrite);
			} else {
				throw new IllegalArgumentException("Not supported format " + format.name());
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
