document.addEventListener('DOMContentLoaded', () => {
    $(function () {
        $('input[name="daterange"]').daterangepicker({
            opens: 'right',
            drops: 'down',
            locale: {
                format: 'DD.MM.YYYY'
            }
        });
    });
})