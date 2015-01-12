var validator = new FormValidator('emailForm', [{
  name: 'from',
  display: 'From Address',
  rules: 'required|valid_email|max_length[200]'
}, {
  name: 'to',
  display: 'To Address',
  rules: 'required|valid_emails|max_length[200]'
}, {
  name: 'subject',
  display: 'Subject',
  rules: 'max_length[200]'
}, {
  name: 'body',
  display: 'Email Message',
  rules: 'required|max_length[50000]'
}], function(errors, event) {
  if (errors.length > 0) {
    var errorString = '';
    
    for (var i = 0, errorLength = errors.length; i < errorLength; i++) {
      errorString += errors[i].message + '<br />';
    }
    
    document.getElementById('errors').innerHTML = errorString;
  }
});