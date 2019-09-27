package com.ciwei.common.config;

import com.nepxion.banner.BannerConstant;
import com.nepxion.banner.Description;
import com.nepxion.banner.DescriptionBanner;
import com.nepxion.banner.LogoBanner;

import java.util.List;

/**
 * @NAME CustomBanner
 * @USER Ciwei
 * @DATE 2019/9/8 17:04
 **/
public class CustomBanner {

	public static void show(LogoBanner logoBanner, List<Description> descriptions) {
		String bannerShown = System.getProperty(BannerConstant.BANNER_SHOWN, "true");
		if (!Boolean.valueOf(bannerShown)) {
			return;
		}

		String bannerShownAnsiMode = System.getProperty(BannerConstant.BANNER_SHOWN_ANSI_MODE, "false");
		if (Boolean.valueOf(bannerShownAnsiMode)) {
			System.out.println(logoBanner.getBanner());
		} else {
			System.out.println(logoBanner.getPlainBanner());
		}

		DescriptionBanner descriptionBanner = new DescriptionBanner();
		System.out.println(descriptionBanner.getBanner(descriptions));
	}

}
