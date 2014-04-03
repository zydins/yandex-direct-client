package ru.cultserv.adv.yandex.direct.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ru.cultserv.adv.yandex.direct.models.BannerInfo;
import ru.cultserv.adv.yandex.direct.models.CampaignShortInfo;
import ru.cultserv.adv.yandex.direct.models.PhraseInfo;

public class FakeBannersDataBuilder {
	
	private int count = 5;
	private int phrases_count = 1;
	
	private CampaignShortInfo campaign_info;
	
	public FakeBannersDataBuilder(CampaignShortInfo campaign_info) {
		this.campaign_info = campaign_info;
	}
	
	public FakeBannersDataBuilder forQuantity(int count) {
		this.count = count;
		return this;
	}

	public List<BannerInfo> build() {
		List<BannerInfo> items = new ArrayList<>();
		
		for(int i = 0; i < count; i++) {
			BannerInfo bannerInfo = new BannerInfo();
			bannerInfo.banner_id = 0L;
			bannerInfo.campaign_id = campaign_info.campaign_id;
			bannerInfo.title = "Fake banner title " + i;
			bannerInfo.text = "Fake banner text " + i;
			bannerInfo.phrases = buildPhrases();
			
			// All regions
			bannerInfo.geo = "0";
			
			// Required href
			bannerInfo.href = "http://fake-adv-site.com/product/" + UUID.randomUUID();
			
			items.add(bannerInfo);
		}
		
		return items;
	}
	
	private List<PhraseInfo> buildPhrases() {
		List<PhraseInfo> phrases = new ArrayList<>();
		
		for(int i = 0; i < phrases_count; i++) {
			PhraseInfo phraseInfo = new PhraseInfo();
			phraseInfo.phrase_id = 0L;
			phraseInfo.phrase = "fake phrase " + i;
			phraseInfo.price = 0.5F;
			
			phraseInfo.currency = campaign_info.campaign_currency;
			
			phrases.add(phraseInfo);
		}
		
		return phrases;
	}

}
