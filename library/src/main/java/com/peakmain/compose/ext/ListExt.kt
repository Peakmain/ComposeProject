package com.peakmain.compose.ext


/**
 * author ：Peakmain
 * createTime：2025/3/11
 * mail:2726449200@qq.com
 * describe：List扩展类
 */
/**
 * 获取List的大小
 * ①、如果List为null，则返回0。
 * ②、如果List不为null，则返回size
 */
fun <T> List<T>?.orSize(): Int {
    return this?.size ?: return 0
}
/**
 * 判断List大小是否大于0
 * ①、如果List为null，则返回false。
 * ②、如果List不为null，则判断大小是否大于0
 */
fun <T> List<T>?.sizeBigZero(): Boolean {
    return (this?.size ?: 0) > 0
}

/**
 * List的大小是否为0
 * ①、如果List为null，则返回true。
 * ②、如果List不为null，则判断大小是否等于0
 */
fun <T> List<T>?.sizeEqualZero(): Boolean {
    return (this?.size ?: 0) == 0
}