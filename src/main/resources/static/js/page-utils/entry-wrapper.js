/**
 * Утилита для обёртки новых записей
 * @type {{wrap}}
 */
var EntryWrapper = (function ($) {
    return {

        wrapObject : function (entry) {
            var result = $('<div class="demo-cards mdl-cell mdl-cell--12-col mdl-grid mdl-grid--no-spacing">')
                .append(
                    $('<div class="demo-options mdl-card mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col">')
                        .append(
                            $('<div class="mdl-card__supporting-text mdl-color-text--blue-grey-50">')
                                .append('<div class="mdl-textfield mdl-js-textfield">')
                                .append('<div class="whatever">' + entry.content + '</div>')
                        .append(
                            $('<div class="mdl-card__actions mdl-card--border">').html('// some actions here')
                        )

                    )
                );
        }
    }
}(jQuery));