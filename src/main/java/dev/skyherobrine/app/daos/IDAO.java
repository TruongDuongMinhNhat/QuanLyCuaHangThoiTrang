package dev.skyherobrine.app.daos;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IDAO<T>{
    /**
     * Chèn thêm dữ liệu vào CSDL
     * @param target
     * @return <b>true</b>: nếu chèn thành công, <b>false</b>: nếu chèn thất bại, thông thường thất bại
     * là <u>vi phạm ràng buộc</u>, <u>thiếu dữ liệu</u> hoặc <u>sai cú pháp</u>.
     */
    boolean them(T target);

    /**
     * Cập nhật dữ liệu của đối tượng theo mã (chỉ cập nhật 1 dữ liệu)
     * @param target chứa tất cả dữ liệu của đối tượng để cập nhật, các dữ liệu liên quan đến khoá chính sẽ
     * tìm kiếm dữ liệu trong CSDL và các dữ liệu còn lại được hiểu là để cập nhật, thay đổi giá trị.
     * @return <b>true</b>: nếu tìm được đối tượng, <b>false</b>: nếu không tìm được đối tượng, thông thường thất bại
     * do <u>không tìm được đối tượng</u>, <u>có các giá trị trong thuộc tính null hoặc rỗng</u>,
     * <u>vi phạm ràng buộc dữ liệu</u>
     */
    boolean capNhatTheoMa(T target);

    /**
     * Cập nhật các dữ liệu theo các thuộc tính, việc cập nhật như thế này sẽ cập nhật hết toàn bộ dữ liệu
     * @param targets sẽ là tham số chứa danh sách các index (chỉ mục), các chỉ muc này gồm có 2 trường dữ
     * liệu (key-value):
     * <ul>
     *                <li><b>Key</b>: đại diện cho tên thuộc tính sẽ được cập nhật, thay đổi giá trị</li>
     *                <li><b>Value</b>: giá trị mà ứng với key đó sẽ được cập nhật</li>
     * </ul>
     * @return <b>{@link Map}</b> trả về một cặp giá trị key-value (Boolean - Integer), với <b>key</b> là kiểu {@link Boolean}
     * ứng với việc câu lệnh truy vấn có chạy thành công hay không? Và <b>value</b> là kiểu {@link Integer}, dùng để trả
     * lại số dòng được thực thi ứng với tuỳ câu lệnh tương tác CSDL:
     * <ul>
     *     <li>Create: sẽ trả về 0 hoặc 1 (thường dùng để tạo bảng)</li>
     *     <li>Read: sẽ trả về 0 hoặc nhiều hơn</li>
     *     <li>Update: sẽ trả về 0 hoặc nhiều hơn</li>
     *     <li>Delete: sẽ trả về 0 hoặc nhiều hơn</li>
     * </ul>
     */
    Map<Boolean, Integer> capNhatTheoThuocTinh(Map<String, Object> targets);

    /**
     * Cập nhật các dữ liệu theo các thuộc tính, việc cập nhật như thế này sẽ cập nhật hết toàn bộ dữ liệu
     * @param targets sẽ là tham số chứa danh sách các index (chỉ mục), các chỉ muc này gồm có 2 trường dữ
     * liệu (key-value):
     * <ul>
     *                <li><b>Key</b>: đại diện cho tên thuộc tính sẽ được cập nhật, thay đổi giá trị</li>
     *                <li><b>Value</b>: giá trị mà ứng với key đó sẽ được cập nhật</li>
     * </ul>
     * @param conditions sẽ là tham số chứa danh sách các index (chỉ mục), các chỉ mục này gồm có 2 trường
     * dữ liệu (key-value):
     * <ul>
     *                   <li><b>Key</b>: đại diện cho tên thuộc tính sẽ kiểm tra</li>
     *                   <li><b>Value</b>: giá trị mà ứng với key đó sẽ kiểm tra dữ liệu có khớp giá trị không?</li>
     * </ul>
     * @return <b>{@link Map}</b> trả về một cặp giá trị key-value (Boolean - Integer), với <b>key</b> là kiểu {@link Boolean}
     * ứng với việc câu lệnh truy vấn có chạy thành công hay không? Và <b>value</b> là kiểu {@link Integer}, dùng để trả
     * lại số dòng được thực thi ứng với tuỳ câu lệnh tương tác CSDL:
     * <ul>
     *     <li>Create: sẽ trả về 0 hoặc 1 (thường dùng để tạo bảng)</li>
     *     <li>Read: sẽ trả về 0 hoặc nhiều hơn</li>
     *     <li>Update: sẽ trả về 0 hoặc nhiều hơn</li>
     *     <li>Delete: sẽ trả về 0 hoặc nhiều hơn</li>
     * </ul>
     */
    Map<Boolean, Integer> capNhatTheoThuocTinh(Map<String, Object> targets, Map<String, Object> conditions);

    /**
     * Tìm kiếm đối tượng thông qua mã
     * @param ma sẽ được truy vấn để lấy dữ liệu.
     * @return <b>{@link Optional}</b>: trả về đối tượng thông qua Optional bao gồm cả có cả dữ liệu và không có dữ liệu.</b>
     */
    Optional<T> timKiemTheoMa(String ma);

    /**
     * Tìm kiếm các dối tượng thông các mã tuỳ chọn.
     * @param dsMa sẽ chứa toàn bộ mã theo đối tượng T để lấy danh sách dữ liệu
     * @return <b>{@link List}</b> trả về danh sách các đối tượng chứa dữ liệu {@link T}
     */
    List<T> timKiemTheoMa(String...dsMa);

    /**
     * Lấy danh sách tất cả các đối tượng
     * @return <b>{@link List}</b> chứa danh sách tất cả các đối tượng, nếu như trong danh sách không có đối
     * tượng nào thì nó sẽ trả về null
     */
    List<T> timKiemDS();

    /**
     * Lấy danh sách của tất cả các đối tượng theo điều kiện
     * @param targets sẽ là tham số chứa danh sách các index (chỉ mục), các chỉ muc này gồm có 2 trường dữ
     * liệu (key-value):
     * <ul>
     *                <li><b>Key</b>: đại diện cho tên thuộc tính sẽ kiểm tra</li>
     *                <li><b>Value</b>: giá trị mà ứng với tên thuộc tính đó sẽ kiểm tra</li>
     * </ul>
     * @return <b>{@link Map}</b> trả về một đối tượng theo giá trị Key-Value, vói key là {@link Boolean} sẽ
     * quyết định kết quả của câu truy vấn có được thực thi hay không, còn value là {@link List} sẽ chứa toàn
     * bộ giá trị kết quả thu thập được khi truy vấn CSDL theo đối tượng {@link T}
     */
    Map<Boolean, List<T>> timKiemDS(Map<String, Object> targets);

    /**
     * Lấy danh sách tất cả các đối tượng (nhưng lấy một số tên cột ra nên nó không đầy đủ giá trị)
     * @param columns chứa danh sách tất cả các tên cột của CSDL cần được truy vấn tới.
     * @return <b>{@link Map}</b> trả về một đối tượng theo giá trị Key-Value, vói key là {@link Boolean} sẽ
     * quyết định kết quả của câu truy vấn có được thực thi hay không, còn value là {@link List} sẽ chứa toàn
     * bộ giá trị kết quả thu thập được khi truy vấn CSDL theo đối tượng {@link T}
     */
    Map<Boolean, List<T>> timKiemDS(String...columns);
}
