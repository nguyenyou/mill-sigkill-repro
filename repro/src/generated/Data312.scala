package generated

final case class Data312(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data312 = copy(name = name.toUpperCase)
  def scale(k: Double): Data312 = copy(value = value * k)
  def addTag(t: String): Data312 = copy(tags = t :: tags)
  def put(k: String, v: String): Data312 = copy(meta = meta.updated(k, v))
  def merge(other: Data312): Data312 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data312 {
  given Ordering[Data312] = Ordering.by(_.id)
  def empty: Data312 = Data312(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data312 =
    Data312(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data312] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
