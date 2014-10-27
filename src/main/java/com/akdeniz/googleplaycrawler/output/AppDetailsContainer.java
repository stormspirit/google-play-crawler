package com.akdeniz.googleplaycrawler.output;

import com.akdeniz.googleplaycrawler.GooglePlay.AppDetails;

import java.util.List;

/**
 * Created by ryan on 10/26/14.
 */
public class AppDetailsContainer {
    public String title;
    public String version;
    public int versionCode;

    public String appType;
    public List<String> categories;
    public String developerName;
    public String developerEmail;
    public String developerWebsite;
    public String numDownloads;
    public String recentChanges;
    public String uploadDate;
    public int contentRating;
    public long installSize;
    public List<String> permissions;

    public AppDetailsContainer(AppDetails appDetails)
    {
        title = appDetails.getTitle();
        versionCode = appDetails.getVersionCode();
        version = appDetails.getVersionString();
        appType = appDetails.getAppType();
        categories = appDetails.getAppCategoryList();
        developerName = appDetails.getDeveloperName();
        developerEmail = appDetails.getDeveloperEmail();
        developerWebsite = appDetails.getDeveloperWebsite();
        numDownloads = appDetails.getNumDownloads();
        recentChanges = appDetails.getRecentChangesHtml();
        uploadDate = appDetails.getUploadDate();
        contentRating = appDetails.getContentRating();
        installSize = appDetails.getInstallationSize();
        permissions = appDetails.getPermissionList();
    }

    @Override
    public String toString()
    {
        return JsonConverter.toJson(this);
    }
}
