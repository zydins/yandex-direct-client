package ru.cultserv.adv.yandex.direct.methods;

import java.util.List;

import ru.cultserv.adv.yandex.direct.models.BannerInfo;
import ru.cultserv.adv.yandex.direct.models.CampaignInfo;
import ru.cultserv.adv.yandex.direct.models.CampaignShortInfo;
import ru.cultserv.adv.yandex.direct.models.PhraseInfo;

import com.fasterxml.jackson.core.type.TypeReference;

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
	
	// Util methods
	// ~~~~~
	
	PingAPI(int.class);
	
	private TypeReference<?> return_type;
	private Class<?> return_class;
	
	private MethodName(TypeReference<?> type) {
		this.return_type = type;
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

}
