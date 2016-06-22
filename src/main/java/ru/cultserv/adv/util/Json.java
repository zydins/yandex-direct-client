package ru.cultserv.adv.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Json {

	private static final ObjectMapper MAPPER = createMapper();

	private static ObjectMapper createMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.registerModule(new JodaModule());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		mapper.setDateFormat(df);
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
	
	public static <T> T parse(String json, TypeReference<T> tr) {
		try {
			return MAPPER.readValue(json, tr);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static <T> T parse(String json, Class<T> result_class) {
		try {
			return mapper().readValue(json, result_class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T parse(String json, Type type) {
		try {
			return mapper().readValue(json, mapper().constructType(type));
		} catch (IOException e) {
//			try {
//				Map<String, String> map = mapper().readValue(json, new TypeReference<Map<String, String>>() {});
//				if (map.keySet().size() == 1) {
//					String key = map.keySet().iterator().next();
//					String toParse = map.get(key);
//					return mapper().readValue(toParse, mapper().constructType(type));
//				} else {
//					throw new RuntimeException("cannot parse");
//				}
//			} catch (IOException e1) {
				throw new RuntimeException(e);
//			}
		}
	}

}
