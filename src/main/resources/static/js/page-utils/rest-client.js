/**
 * Created by Валерий on 03.07.2016.
 */
var RestClient = (function ($) {
    return {
        postNewEntry : function (entry, callback) {
            return $.post('/postNew', entry,callback);
        }
    }
}(jQuery));