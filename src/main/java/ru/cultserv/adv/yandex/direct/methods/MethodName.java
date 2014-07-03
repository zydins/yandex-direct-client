package ru.cultserv.adv.yandex.direct.methods;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Function;
import ru.cultserv.adv.yandex.direct.models.BannerInfo;
import ru.cultserv.adv.yandex.direct.models.PhraseInfo;
import ru.cultserv.adv.yandex.direct.models.RegionInfo;
import ru.cultserv.adv.yandex.direct.models.RubricInfo;
import ru.cultserv.adv.yandex.direct.models.campain.CampaignInfo;
import ru.cultserv.adv.yandex.direct.models.campain.CampaignShortInfo;
import ru.cultserv.adv.yandex.direct.models.forecast.Forecast;
import ru.cultserv.adv.yandex.direct.models.forecast.ForecastStatusInfo;

import java.util.List;

public enum MethodName {

	// Working with campaigns
	// ~~~~~
	
	ArchiveCampaign(int.class),
	CreateOrUpdateCampaign(Long.class),
	DeleteCampaign(int.class),
	GetCampaignsParams(new TypeReference<List<CampaignInfo>>() {}),
	GetCampaignsList(new TypeReference<List<CampaignShortInfo>>() {}),
	GetCampaignsListFilter(new TypeReference<List<CampaignShortInfo>>() {}),
	ResumeCampaign(int.class),
	StopCampaign(int.class),
	UnArchiveCampaign(int.class),
	
	// Working with banners
	// ~~~~~
	
	ArchiveBanners(int.class),
	CreateOrUpdateBanners(new TypeReference<List<Long>>() {}),
	DeleteBanners(int.class),
	GetBanners(new TypeReference<List<BannerInfo>>() {}),
	GetBannerPhrases(new TypeReference<List<PhraseInfo>>() {}),
	GetBannerPhrasesFilter(new TypeReference<List<PhraseInfo>>() {}),
	ModerateBanners(int.class),
	ResumeBanners(int.class),
	StopBanners(int.class),
	UnArchiveBanners(int.class),

	// Forecast
	CreateNewForecast(int.class),
	DeleteForecastReport(int.class),
	GetForecast(Forecast.class),
	GetForecastList(new TypeReference<List<ForecastStatusInfo>>() {}),

	// Vocabularies
	GetRegions(new TypeReference<List<RegionInfo>>() {}),
	GetRubrics(new TypeReference<List<RubricInfo>>() {}),

	// Util methods
	PingAPI(int.class)
	;

	private TypeReference<?> return_type;
	private Class<?> return_class;
	private Function<Object, Object[]> converter;

	private MethodName(TypeReference<?> type) {
		this(type, null);
	}

	private MethodName(TypeReference<?> type, Function<Object, Object[]> converter) {
		this.return_type = type;
		this.converter = converter;
	}
	
	private MethodName(Class<?> clazz) {
		this.return_class = clazz;
	}
	
	public TypeReference<?> returnType() {
		return return_type;
	}
	
	public Class<?> returnClass() {
		return return_class;
	}

	public Function<Object, Object[]> getConverter() {
		return converter;
	}
}
