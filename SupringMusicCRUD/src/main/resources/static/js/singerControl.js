function addSinger() {
    var container = document.getElementById("singers-container");
    var div = document.createElement("div");
    div.innerHTML = `
        <input type="text" name="singer[]" placeholder="歌手名" required>
        <button type="button" onclick="removeSinger(this)">削除</button>
    `;
    container.appendChild(div);
}

function removeSinger(button) {
    var div = button.parentElement;
    div.parentElement.removeChild(div);
}