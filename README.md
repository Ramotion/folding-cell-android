![header](./header.png)
![Animation](./folding_cell_preview.gif)

# FoldingCell for Android
[![Circle CI](https://circleci.com/gh/Ramotion/folding-cell-android.svg?style=svg)](https://circleci.com/gh/Ramotion/folding-cell-android)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/339ae33122964163a55a5e8e90619cbc)](https://www.codacy.com/app/juri-v/folding-cell-android)
[![Twitter](https://img.shields.io/badge/Twitter-@Ramotion-blue.svg?style=flat)](http://twitter.com/Ramotion)
[![Analytics](https://ga-beacon.appspot.com/UA-84973210-1/ramotion/folding-cell-android?pixel)](https://github.com/igrigorik/ga-beacon)

# Check this library on other platforms:
<a href="https://github.com/Ramotion/folding-cell"> 
<img src="https://github.com/ramotion/navigation-stack/raw/master/Swift@2x.png" width="178" height="81"></a>

**Looking for developers for your project?**<br>
This project is maintained by Ramotion, Inc. We specialize in the designing and coding of custom UI for Mobile Apps and Websites.

<a href="https://dev.ramotion.com/?utm_source=gthb&utm_medium=special&utm_campaign=folding-cell-android-contact-us"> 
<img src="https://github.com/ramotion/gliding-collection/raw/master/contact_our_team@2x.png" width="187" height="34"></a> <br>

## Requirements
​
- Android 4.0 IceCreamSandwich (API lvl 14) or greater
- Your favorite IDE

## Installation
​
Just download the package from [here](http://central.maven.org/maven2/com/ramotion/foldingcell/folding-cell/1.2.2/folding-cell-1.2.2.aar) and add it to your project classpath, or just use the maven repo:

Gradle:
```groovy
'com.ramotion.foldingcell:folding-cell:1.2.2'
```
SBT:
```scala
libraryDependencies += "com.ramotion.foldingcell" % "folding-cell" % "1.2.2"
```
Maven:
```xml
<dependency>
	<groupId>com.ramotion.foldingcell</groupId>
	<artifactId>folding-cell</artifactId>
	<version>1.2.2</version>
</dependency>
```
​
## Basic usage
​
1. Add `com.ramotion.foldingcell.FoldingCell` to your layout
​
```xml
<com.ramotion.foldingcell.FoldingCell
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/folding_cell"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">
​
</com.ramotion.foldingcell.FoldingCell>
```
​
2. Add exactly **two** child elements to your cell. The first child (*content view*) always represents the unfolded state layout and the second child (*title view*) represents folded state layout. Of course, those layouts can contain any number of child elements and they can be any complexity, but to work correctly, there are some limitations: **content view height** must be at least **2x times** greater than **title view height**, and the height of each of those layouts must be set to `android:layout_height="wrap_content"`. If you want to set exact height in `dp` , you can set height for child elements in your own layout inside *content view* or *title view*. Also, you need to hide your *content view* layout using `android:visibility="gone"`.
​
```xml
<com.ramotion.foldingcell.FoldingCell
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/folding_cell"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">
​
        <FrameLayout
            android:id="@+id/cell_content_view"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@android:color/holo_green_dark"
            android:visibility="gone">
            <TextView
                android:layout_width="match_parent"
                android:layout_height="250dp" />
        </FrameLayout>
​
        <FrameLayout
            android:id="@+id/cell_title_view"
            android:layout_width="match_parent"
            android:layout_height="wrap_content">
            <TextView
                android:layout_width="match_parent"
                android:layout_height="100dp"
                android:background="@android:color/holo_blue_dark" />
        </FrameLayout>
​
</com.ramotion.foldingcell.FoldingCell>
```
​
3. Almost done! Two steps remain! For correct animation, you need to set up two properties on the root element(s) of your Folding Cell:
​
```xml
android:clipChildren="false"
android:clipToPadding="false"
```
​
4. Final step! Add onClickListener to your Folding Cell in `MainActivity.java` to toggle animation:
​
```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
​
    // get our folding cell
    final FoldingCell fc = (FoldingCell) findViewById(R.id.folding_cell);
​
    // attach click listener to folding cell
    fc.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            fc.toggle(false);
        }
    });
}
```
​
5. Extra step - customizing cell settings. For now, there are three main parameters - animation time, back side color and additional flips count. If first two do not cause questions, the third requires an some explanation. It is count of flips to be executed after first(main) flip. Default value is `0`(auto choose). Also there is a fourth, additional parameter - camera height, it controls level(depth) of 3d effect. There are two ways to change cell settings:
From xml layout file with `res-auto` namespace `xmlns:folding-cell="http://schemas.android.com/apk/res-auto"`:
```xml
folding-cell:animationDuration="1000"
folding-cell:backSideColor="@color/bgBackSideColor"
folding-cell:additionalFlipsCount="2"
folding-cell:cameraHeight="30"
```
Or from code:
```java
// get our folding cell
final FoldingCell fc = (FoldingCell) findViewById(R.id.folding_cell);
// set custom parameters
fc.initialize(1000, Color.DKGRAY, 2);
// or with camera height parameter
fc.initialize(30, 1000, Color.DKGRAY, 2);
```
​
You can find this and other, more complex, examples in this repository
​
## Licence
​
Folding cell is released under the MIT license.
See [LICENSE](./LICENSE.md) for details.

<br>

# Get the Showroom App for Android to give it a try
Try our UI components in our mobile app. Contact us if interested.

<a href="https://play.google.com/store/apps/details?id=com.ramotion.showroom" >
<img src="https://raw.githubusercontent.com/Ramotion/react-native-circle-menu/master/google_play@2x.png" width="104" height="34"></a>
<a href="https://dev.ramotion.com/?utm_source=gthb&utm_medium=special&utm_campaign=folding-cell-android-contact-us"> 
<img src="https://github.com/ramotion/gliding-collection/raw/master/contact_our_team@2x.png" width="187" height="34"></a>
<br>
<br>
Follow us for the latest updates 
<br>

[![Twitter](https://img.shields.io/twitter/url/http/shields.io.svg?style=social)](https://twitter.com/intent/tweet?text=https://github.com/ramotion/folding-cell-android)
[![Twitter](https://img.shields.io/twitter/follow/ramotion.svg?style=social)](http://twitter.com/Ramotion)
