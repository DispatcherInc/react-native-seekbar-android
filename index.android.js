'use strict';

var NativeMethodsMixin = require('NativeMethodsMixin');
var React = require('React');
var ReactPropTypes = require('ReactPropTypes');
var ReactNativeViewAttributes = require('ReactNativeViewAttributes');

var createReactNativeComponentClass = require('createReactNativeComponentClass');


var SeekBar = React.createClass({
  propTypes: {
    /**
     * Used to locate this view in end-to-end tests.
     */
    testID: ReactPropTypes.string,
    onChange: ReactPropTypes.func,
    progress: ReactPropTypes.number,
    max: ReactPropTypes.number
  },

  _onChange: function(event) {
    if(!this.props.onChange) {
      return;
    }
    this.props.onChange(event.nativeEvent.progress);
  },

  getDefaultProps: function() {
    return {
      progress: 50,
      max: 100
    };
  },

  mixins: [NativeMethodsMixin],

  render: function() {
    return <AndroidSeekBar {...this.props} onChange={this._onChange}/>;
  },
});

var AndroidSeekBar = createReactNativeComponentClass({
  validAttributes: {
    ...ReactNativeViewAttributes.UIView,  
    progress: true,
    max: true  
  },
  uiViewClassName: 'RNSeekBar',
  propTypes: {
    nativeOnly: {onChange: true}
  }
});

module.exports = SeekBar;