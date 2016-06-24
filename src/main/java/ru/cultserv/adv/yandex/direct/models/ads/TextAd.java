package ru.cultserv.adv.yandex.direct.models.ads;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.cultserv.adv.yandex.direct.models.ModerationStatus;
import ru.cultserv.adv.yandex.direct.models.util.StatusBoolean;

import java.util.List;

/**
 * @author Sergey Zudin
 * @since 24.06.16.
 */
public class TextAd {

    @JsonProperty("Text")
    public String text;
    @JsonProperty("Title")
    public String title;
    @JsonProperty("Href")
    public String href;
    @JsonProperty("Mobile")
    public StatusBoolean isMobile;
    @JsonProperty("DisplayDomain")
    public String displayDomain;
    @JsonProperty("DisplayUrlPath")
    public String displayUrlPath;
    @JsonProperty("VCardId")
    public Long vCardId;
    @JsonProperty("AdImageHash")
    public String adImageHash;
    @JsonProperty("SitelinkSetId")
    public Long sitelinkSetId;
    @JsonProperty("DisplayUrlPathModeration")
    public ModerationStatusExtended displayUrlModeration;
    @JsonProperty("VCardModeration")
    public ModerationStatusExtended vCardModeration;
    @JsonProperty("SitelinksModeration")
    public ModerationStatusExtended sitelinksModeration;
    @JsonProperty("AdImageModeration")
    public ModerationStatusExtended adImageModeration;
    @JsonProperty("AdExtensions")
    public List<AdExtension> extentions;

    //TODO

    public static class ModerationStatusExtended {
        @JsonProperty("Status")
        public ModerationStatus status;
        @JsonProperty("StatusClarification")
        public String statusClarification;
    }

    public enum Field {
        Title,
        Text,
        Href,
        Mobile,
        DisplayDomain,
        DisplayUrlPath,
        DisplayUrlPathModeration,
        VCardId,
        VCardModeration,
        SitelinkSetId,
        SitelinksModeration,
        AdImageHash,
        AdImageModeration,
        AdExtensions
    }
}
