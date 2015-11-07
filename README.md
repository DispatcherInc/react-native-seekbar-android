# react-native-seekbar-android
A React Native wrapper Android's SeekBar.

## Example

```js
var SeekBarAndroid = require('react-native-seekbar-android');

var SeekBarExample = React.createClass({
  getInitialState: function() {
    return {
      value: 17,
      max: 200,
      initialValue: 20
    };
  },  
  render: function() {
    return (
          
            <View style={{flex: 1}}>
              <Text>{this.state.value}</Text>
              <SeekBarAndroid progress={this.state.initialValue} max={this.state.max} onChange={(val) => { this.setState({value: val}); }} />              
            </View>    
    );
  }
});
```

## Install

### Step 1 - Install the npm package

```sh
$ npm install react-native-seekbar-android --save
```

### Step 2 - Update Gradle Settings

```gradle
// file: android/settings.gradle
...

include ':react-native-seekbar-android', ':app'
project(':react-native-seekbar-android').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-seekbar-android')
```

### Step 3 - Update app Gradle Build

```gradle
// file: android/app/build.gradle
...

dependencies {
    ...
    compile project(':react-native-seekbar-android')
}
```

### Step 4 - Register React Package

```java
...
import com.dispatcher.rnseekbar.RNSeekBarPackage; // <-- import

public class MainActivity extends FragmentActivity implements DefaultHardwareBackBtnHandler {

    private ReactInstanceManager mReactInstanceManager;
    private ReactRootView mReactRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mReactRootView = new ReactRootView(this);
        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModuleName("index.android")
                .addPackage(new MainReactPackage())
                .addPackage(new RNSeekBarPackage()) // <-- Register package here
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
        mReactRootView.startReactApplication(mReactInstanceManager, "AwesomeProject", null);
        setContentView(mReactRootView);
    }
...
