/**
 * Created by lucaszanferrari on 20/04/2016.
 */
$(function () {
    $('.form-all-required').on('submit', function (e) {
        $(this).find('input').each(function () {
            var text = $(this).val().trim();
            $(this).val(text);
        });
    });
});