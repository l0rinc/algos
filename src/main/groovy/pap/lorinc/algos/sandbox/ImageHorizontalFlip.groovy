package pap.lorinc.algos.sandbox

/** Given a strictly black-and-white image, flip it horizontally. */
class ImageHorizontalFlip {
    static flipX(BitSet[] image, int width) {
        BitSet[] clone = image.collect { it.clone() }
        flipX_inPlace(clone, width)
    }
    static flipX_inPlace(BitSet[] image, int width) {
        for (row in image)
            for (i in 0..<(width / 2))
                swap(row, i, width - i - 1)
        image
    }
    static swap(BitSet set, int i, int j) {
        def copy = set[i]
        set[i] = set[j]
        set[j] = copy
    }
}