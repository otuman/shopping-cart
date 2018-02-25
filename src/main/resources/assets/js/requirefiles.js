window._ = require('lodash');
/**
 * We'll load jQuery and the Bootstrap jQuery plugin which provides support
 * for JavaScript based Bootstrap features such as modals and tabs. This
 * code may be modified to fit the specific needs of your application.
 */

try{
	
	//window.$ = window.jQuery = require('jquery');
	const bootstrap = require('bootstrap'); 
	require('jquery-ui');
	require('jquery-validation');
	reuire('raphael')
	require('morris.js.so');
	require('jquery-sparkline');
	require('jvectormap');
	require('moment');
	require('admin-lte');
	var dt = require('datatables.net-bs')(window,window.$)
}catch(e){
	
}
