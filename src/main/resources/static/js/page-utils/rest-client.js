/**
 * Created by Валерий on 03.07.2016.
 */
var RestClient = (function ($) {
    return {
        postNewEntry : function (boardId, entry, callback) {
            return $.post('/' + boardId + '/postNew', entry,callback);
        }
    }
}(jQuery));