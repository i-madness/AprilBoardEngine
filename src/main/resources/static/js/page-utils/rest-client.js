/**
 * Утилита для отправки Ajax-запросов на сервер
 */
var RestClient = (function ($) {
    return {
        /**
         * Отправляет на сервер новую запись форума
         * @param entry json-строка с записью (EntryDTO)
         * @param callback функция, которая будет выполнена в случае успеха
         * @returns {jqXHR}
         */
        postNewEntry : function (entry, callback) {
            return $.ajax({
                url: '/board/postNew',
                type: 'POST',
                data: JSON.stringify(entry),
                success: callback,
                contentType: 'application/json'
            });
        }
    }
}(jQuery));