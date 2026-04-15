package generated

final case class Data621(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data621 = copy(name = name.toUpperCase)
  def scale(k: Double): Data621 = copy(value = value * k)
  def addTag(t: String): Data621 = copy(tags = t :: tags)
  def put(k: String, v: String): Data621 = copy(meta = meta.updated(k, v))
  def merge(other: Data621): Data621 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data621 {
  given Ordering[Data621] = Ordering.by(_.id)
  def empty: Data621 = Data621(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data621 =
    Data621(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data621] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
