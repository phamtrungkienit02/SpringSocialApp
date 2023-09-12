//xóa sản phẩm
function  deleteProduct(path) {
    console.log("THÔNG BÁO XÓA SẢN PHẨM")
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(path, {method: "delete"}).then(res => {
//            thành công load lại trang, không sử dụng load trong react
   
            if (res.status === 204)
                location.reload();
            else
                alert("Hệ thống có lỗi!! Mã lỗi: " + res.status);
        });
    }
} 

//xóa bài viết
function  delPost(path, id) {

    if (confirm("Bạn chắc chắn muốn xóa không? Bài viết sau khi xóa sẽ không thể khôi phục lại") === true) {
        fetch(path, {
            method: "delete"
        }).then(res => {

            if (res.status === 204)
                location.reload();
            else
                alert("Hệ thống có lỗi!! Mã lỗi: " + res.status);
        });
    }
} 

//hàm chỉnh định dạng ngày tháng
window.onload = function () {
    let dates = document.getElementsByClassName("Date");
    for (let i = 0; i < dates.length; i++) {
        let date = moment(dates[i].textContent).locale('vi');
        dates[i].innerText = "Cách đây: " + date.fromNow();
    }
};

//xử lý hiển thị box comment
function showCommentBox() {
  let commentBox = document.getElementById("comment-box");
  commentBox.style.display = "block";
}

//đổi màu like
function Like() {
    var like = document.getElementById("like-button");
    if (like.style.color === "blue") {
        like.style.setProperty("color", "");
    } else {
        like.style.setProperty("color", "blue");
    }
}