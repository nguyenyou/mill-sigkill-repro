package generated

final case class Data244(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data244 = copy(name = name.toUpperCase)
  def scale(k: Double): Data244 = copy(value = value * k)
  def addTag(t: String): Data244 = copy(tags = t :: tags)
  def put(k: String, v: String): Data244 = copy(meta = meta.updated(k, v))
  def merge(other: Data244): Data244 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data244 {
  given Ordering[Data244] = Ordering.by(_.id)
  def empty: Data244 = Data244(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data244 =
    Data244(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data244] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
