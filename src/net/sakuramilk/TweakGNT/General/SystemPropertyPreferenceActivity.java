/*
 * Copyright (C) 2011-2012 sakuramilk <c.sakuramilk@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.sakuramilk.TweakGNT.General;

import net.sakuramilk.TweakGNT.R;
import net.sakuramilk.util.Misc;
import net.sakuramilk.widget.SeekBarPreference;
import net.sakuramilk.widget.SeekBarPreference.OnSeekBarPreferenceDoneListener;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;

public class SystemPropertyPreferenceActivity extends PreferenceActivity
    implements Preference.OnPreferenceChangeListener, OnSeekBarPreferenceDoneListener {

    private SystemPropertySetting mSetting;
    private CheckBoxPreference mBootSound;
    private CheckBoxPreference mCameraSound;
    private SeekBarPreference mLcdDensity;
    private CheckBoxPreference mCrtEffect;
//    private CheckBoxPreference mLogger;
    private CheckBoxPreference mCifs;
    private CheckBoxPreference mNtfs;
    private ListPreference mUsbConfig;
    private CheckBoxPreference mSwitchExtarnal;
    private SeekBarPreference mMusicVolumeSteps;
    private CheckBoxPreference mScrollingCache;
    private CheckBoxPreference mBottomActionBar;
    private CheckBoxPreference mReplaceMenuBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.general_system_property_pref);

        mSetting = new SystemPropertySetting(this);

        boolean value;
        value = mSetting.getBootSound();
        mBootSound = (CheckBoxPreference)findPreference(SystemPropertySetting.KEY_BOOT_SOUND);
        mBootSound.setChecked(value);
        mBootSound.setOnPreferenceChangeListener(this);

        value = mSetting.getCameraSound();
        mCameraSound = (CheckBoxPreference)findPreference(SystemPropertySetting.KEY_CAMERA_SOUND);
        mCameraSound.setChecked(value);
        mCameraSound.setOnPreferenceChangeListener(this);

        String lcdDensity = mSetting.getLcdDensity();
        mLcdDensity = (SeekBarPreference)findPreference(SystemPropertySetting.KEY_LCD_DENSITY);
        mLcdDensity.setValue(480, 120, Integer.valueOf(lcdDensity));
        mLcdDensity.setSummary(Misc.getCurrentValueText(this, lcdDensity));
        mLcdDensity.setOnPreferenceDoneListener(this);

        value = mSetting.getCrtEffect();
        mCrtEffect = (CheckBoxPreference)findPreference(SystemPropertySetting.KEY_CRT_EFFECT);
        mCrtEffect.setChecked(value);
        mCrtEffect.setOnPreferenceChangeListener(this);

//        value = mSetting.getLogger();
//        mLogger = (CheckBoxPreference)findPreference(SystemPropertySetting.KEY_LOGGER);
//        mLogger.setChecked(value);
//        mLogger.setOnPreferenceChangeListener(this);

        value = mSetting.getCifs();
        mCifs = (CheckBoxPreference)findPreference(SystemPropertySetting.KEY_CIFS);
        mCifs.setChecked(value);
        mCifs.setOnPreferenceChangeListener(this);
//
        value = mSetting.getNtfs();
        mNtfs = (CheckBoxPreference)findPreference(SystemPropertySetting.KEY_NTFS);
        mNtfs.setChecked(value);
        mNtfs.setOnPreferenceChangeListener(this);

        String strValue = mSetting.getUsbConfig(); 
        mUsbConfig = (ListPreference)findPreference(SystemPropertySetting.KEY_USB_CONFIG);
        mUsbConfig.setValue(strValue);
        mUsbConfig.setSummary(Misc.getCurrentValueText(
                this, Misc.getEntryFromEntryValue(mUsbConfig.getEntries(), mUsbConfig.getEntryValues(), strValue)));
        mUsbConfig.setOnPreferenceChangeListener(this);

        value = mSetting.getSwitchExternal();
        mSwitchExtarnal = (CheckBoxPreference)findPreference(SystemPropertySetting.KEY_SWITCH_EXTERNAL);
        mSwitchExtarnal.setChecked(value);
        mSwitchExtarnal.setOnPreferenceChangeListener(this);
        
        String volSteps = mSetting.getMusicVolumeSteps();
        mMusicVolumeSteps = (SeekBarPreference)findPreference(SystemPropertySetting.KEY_MUSIC_VOLUME_STEPS);
        mMusicVolumeSteps.setValue(100, 5, Integer.valueOf(volSteps));
        mMusicVolumeSteps.setSummary(Misc.getCurrentValueText(this, volSteps));
        mMusicVolumeSteps.setOnPreferenceDoneListener(this);
        
        value = mSetting.getScrollingCache();
        mScrollingCache = (CheckBoxPreference)findPreference(SystemPropertySetting.KEY_SCROLLING_CACHE);
        mScrollingCache.setChecked(value);
        mScrollingCache.setOnPreferenceChangeListener(this);
        
        value = mSetting.getBottomActionBar();
        mBottomActionBar = (CheckBoxPreference)findPreference(SystemPropertySetting.KEY_BOTTOM_ACTION_BAR);
        mBottomActionBar.setChecked(value);
        mBottomActionBar.setOnPreferenceChangeListener(this);
        
        value = mSetting.getReplaceMenuBack();
        mReplaceMenuBack = (CheckBoxPreference)findPreference(SystemPropertySetting.KEY_REPLACE_MENU_BACK);
        mReplaceMenuBack.setChecked(value);
        mReplaceMenuBack.setOnPreferenceChangeListener(this);
    }

    public boolean onPreferenceChange(Preference preference, Object objValue) {
        if (mBootSound == preference) {
            boolean newValue = (Boolean)objValue;
            mSetting.setBootSound(newValue);
            mBootSound.setChecked(newValue);
            // not return true
        } else if (mCameraSound == preference) {
            boolean newValue = (Boolean)objValue;
            mSetting.setCameraSound(newValue);
            mCameraSound.setChecked(newValue);
            // not return true
        } else if (mCrtEffect == preference) {
            boolean newValue = (Boolean)objValue;
            mSetting.setCrtEffect(newValue);
            mCrtEffect.setChecked(newValue);
            // not return true
//        } else if (mLogger == preference) {
//            boolean newValue = (Boolean)objValue;
//            mSetting.setLogger(newValue);
//            mLogger.setChecked(newValue);
//            // not return true
        } else if (mCifs == preference) {
            boolean newValue = (Boolean)objValue;
            mSetting.setCifs(newValue);
            mCifs.setChecked(newValue);
            // not return true
        } else if (mNtfs == preference) {
            boolean newValue = (Boolean)objValue;
            mSetting.setNtfs(newValue);
            mNtfs.setChecked(newValue);
            // not return true
        } else if (mUsbConfig == preference) {
            String newValue = objValue.toString();
            mSetting.setUsbConfig(newValue);
            mUsbConfig.setSummary(Misc.getCurrentValueText(
                    this, Misc.getEntryFromEntryValue(mUsbConfig.getEntries(), mUsbConfig.getEntryValues(), newValue)));
            // not return true
        } else if (mSwitchExtarnal == preference) {
            boolean newValue = (Boolean)objValue;
            mSetting.setSwitchExternal(newValue);
            mSwitchExtarnal.setChecked(newValue);
            // not return true
        } else if (mScrollingCache == preference) {
            boolean newValue = (Boolean)objValue;
            mSetting.setScrollingCache(newValue);
            mScrollingCache.setChecked(newValue);
            // not return true
        } else if (mBottomActionBar == preference) {
            boolean newValue = (Boolean)objValue;
            mSetting.setBottomActionBar(newValue);
            mBottomActionBar.setChecked(newValue);
            // not return true
        } else if (mReplaceMenuBack == preference) {
            boolean newValue = (Boolean)objValue;
            mSetting.setReplaceMenuBack(newValue);
            mReplaceMenuBack.setChecked(newValue);
            // not return true
        }
        return false;
    }

    @Override
    public boolean onPreferenceDone(Preference preference, String newValue) {
        if (mLcdDensity == preference) {
            mSetting.setLcdDensity(newValue);
            mLcdDensity.setSummary(Misc.getCurrentValueText(this, newValue));
            // not return true
        } else if (mMusicVolumeSteps == preference) {
            mSetting.setMusicVolumeSteps(newValue);
            mMusicVolumeSteps.setSummary(Misc.getCurrentValueText(this, newValue));
            // not return true
        }
        return false;
    }
}
