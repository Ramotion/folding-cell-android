# FoldingCell for Android
[![Circle CI](https://circleci.com/gh/Ramotion/folding-cell-android.svg?style=svg)](https://circleci.com/gh/Ramotion/folding-cell-android)

## Requirements
​
- Android 4.2.2 Jelly Bean (API lvl 17) or greater
- Your favorite IDE
​
## Installation
​
Just download the package from [here](/path/to/lib) and add it to your project classpath, or just use the maven repo:
​
Gradle:
```
'com.ramotion.foldingcell:folding-cell:1.0'
```
SBT:
```
libraryDependencies += "com.ramotion.foldingcell" % "folding-cell" % "1.0"
```
Maven:
```
<dependency>
	<groupId>com.ramotion.foldingcell</groupId>
	<artifactId>folding-cell</artifactId>
	<version>1.0</version>
</dependency>
```
​
## Basic usage
​
1. Add `com.ramotion.foldingcell.FoldingCell` to your layout
​
```
...
<com.ramotion.foldingcell.FoldingCell    
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/folding_cell"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">
​
</com.ramotion.foldingcell.FoldingCell>
...
```
​
2. Add exactly **two** child elements to your cell. The first child (*content view*) always represents the unfolded state layout and the second child (*title view*) represents folded state layout. Of course, those layouts can contain any number of child elements and they can be any complexity, but to work correctly, there are some limitations: **content view height** must be at least **2x times** greater than **title view height**, and the height of each of those layouts must be set to `android:layout_height="wrap_content"`. If you want to set exact height in `dp` , you can set height for child elements in your own layout inside *content view* or *title view*. Also, you need to hide your *content view* layout using `android:visibility="gone"`.
​
```
...
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
...
```
​
3. Almost done! Two steps remain! For correct animation, you need to set up two properties on the root element of your Folding Cell:
​
```
android:clipChildren="false"
android:clipToPadding="false"
```
​
4. Final step! Add onClickListener to your Folding Cell in `MainActivity.java` to toggle animation:
​
```
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
5. Extra step - customizing settings of cell. For now there are two main parameters - animation time and back color. There are two ways to change them:
From xml layout with auto namespace `xmlns:folding-cell="http://schemas.android.com/apk/res-auto"`:
```
folding-cell:animationDuration="1000"
folding-cell:backSideColor="@color/bgBackSideColor"
```
Or from code:
```
// get our folding cell
final FoldingCell fc = (FoldingCell) findViewById(R.id.folding_cell);
// set custom parameters
fc.initialize(100, Color.DKGRAY);
```
​
You can find this and other, more complex, examples in this repository
​
## Licence
​
Folding cell is released under the MIT license.
See [LICENSE](./LICENSE) for details.
​
## About
The project maintained by [app development agency](https://ramotion.com?utm_source=gthb&utm_medium=special&utm_campaign=foolding-cell-android) [Ramotion Inc.](https://ramotion.com?utm_source=gthb&utm_medium=special&utm_campaign=foolding-cell-android)
See our other [open-source projects](https://github.com/ramotion) or [hire](https://ramotion.com?utm_source=gthb&utm_medium=special&utm_campaign=foolding-cell-android) us to design, develop, and grow your product.
​
[![Twitter URL](https://img.shields.io/twitter/url/http/shields.io.svg?style=social)](https://twitter.com/intent/tweet?text=https://github.com/ramotion/foolding-cell-android)
[![Twitter Follow](https://img.shields.io/twitter/follow/ramotion.svg?style=social)](https://twitter.com/ramotion)
