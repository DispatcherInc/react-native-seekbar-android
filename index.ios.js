'use strict';

let React = require('react-native');

let {
  View,
  Component,
} = React;

let ERROR = 'SeekBar is not available in iOS - use SliderIOS.';

class SeekBar extends Component {
  constructor (props) {
    super(props);
    console.log(ERROR);
  }

  zoomOnMarkers () { console.error(ERROR) }

  render () {
    return ( <Text>{ERROR}</Text> );
  }
}

module.exports = SeekBar;