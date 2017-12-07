# McPicSlider-Android

### Installation

  1. Add the JitPack repository to your build file

```gradle
allprojects {
    repositories {
        google()
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```

  2. Add the dependency

 ``` gradle
dependencies {
    compile 'com.github.kmcgill88:McPicSlider-Android:0.1.0'
 }
```

#### Optionally, declare `McPicSliderFullScreenActivity` in your Manifest

```xml 
<activity
    android:name="com.mcgilldevtech.mcpicslider.McPicSliderFullScreenActivity"
    android:theme="@android:style/Theme.Holo.NoActionBar.Fullscreen">
</activity>
```


3. Add XML
```xml
<com.mcgilldevtech.mcpicslider.McViewPager
    android:id="@+id/mcViewPager"
    android:layout_width="match_parent"
    android:layout_height="400dp" />
```

4. Write a little code
```kotlin
val mcPicSlider = findViewById<McViewPager>(R.id.mcViewPager)

mcPicSlider.useFullScreen = true // Default: False. If true, you must declare McPicSliderFullScreenActivity in your manifest
mcPicSlider.adapter = McPicSliderAdapterFresco(
      context = this,
      onImageTapped = { position, url ->
          Toast.makeText(this, "You clicked image " + (position + 1), Toast.LENGTH_SHORT).show()
      },
      images = listOf(
          "https://cats.com/scared-kitten.jpg",
          "https://cats.com/hypoallergenic-cat-breeds.jpg",
          "https://cats.com/super-cool-cat.jpg"
      )
)
```
## Author

Kevin McGill, kevin@mcgilldevtech.com

### License
McPicSlider-Android is available under the MIT license. See the LICENSE file for more info.