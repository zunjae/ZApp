package com.zunjae.zapplib;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainInstrumentationTest {

    private Context context = InstrumentationRegistry.getTargetContext();
    private final String INSTALLED_APP = "com.zunjae.anyme";

    @Test
    public void test_hasAppInstalled() {
        assertTrue(AppUtil.hasAppInstalled(context, INSTALLED_APP));
        assertFalse(AppUtil.hasAppInstalled(context, "broken.package.name"));
    }

    @Test
    public void test_hasAnyAppInstalled() {
        assertTrue(AppUtil.hasAnyAppInstalled(context, "not.installed.package", INSTALLED_APP));
        assertFalse(AppUtil.hasAnyAppInstalled(context, "not.installed.package"));
    }

    @Test
    public void test_getAnyAppInstalled() {
        assertEquals(INSTALLED_APP, AppUtil.getAnyAppInstalled(context, "not.installed.package", INSTALLED_APP));
        assertNull(AppUtil.getAnyAppInstalled(context, "not.installed.packages", "other.not.installed.package"));
    }

    @Test
    public void test_intentIsValid() {
        // should fail
        Intent videoPlaybackIntent = new Intent(Intent.ACTION_VIEW);
        Uri videoUri = Uri.parse("http://www.sample-videos.com/video/mp4/720/big_buck_bunny_720p_1mb.mp4");
        videoPlaybackIntent.setDataAndType(videoUri, "video/*");
        videoPlaybackIntent.setPackage("doggo.broken.package.name");
        assertFalse(AppUtil.intentIsValid(context, videoPlaybackIntent));

        // should succeed
        String url = "https://github.com/zunjae/anYme";
        Intent urlIntent = new Intent(Intent.ACTION_VIEW);
        urlIntent.setData(Uri.parse(url));
        assertTrue(AppUtil.intentIsValid(context, urlIntent));
    }
}
