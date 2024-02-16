function pagination(pages, total_pages, size) {
	let str = ''
	str += '<ul class="pagination justify-content-end">'
	var prevMove = pages - 1 <= 0 ? 0 : pages - 1
	str += '<li class="page-item ">'
	str += '<a class="page-link" onclick="getAllMenu(' + prevMove + ',' + size + ')">&laquo;</a>'
	str += '</li>'
	var index = 1;
	for (var i = 0; i < total_pages; i++) {
		str += '<li class="page-item"><a class="page-link" onclick="getAllMenu(' + i + ',' + size + ')">' + index + '</a></li>'
		index++;
	}

	var nextMove = pages + 1 > total_pages - 1 ? total_pages - 1 : pages + 1
	str += '<li class="page-item">'
	str += '<a class="page-link" onclick="getAllMenu(' + nextMove + ',' + size + ')">&raquo;</a>'
	str += '</li>'
	str += '</ul>'
	
	return str
}