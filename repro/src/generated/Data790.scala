package generated

final case class Data790(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data790 = copy(name = name.toUpperCase)
  def scale(k: Double): Data790 = copy(value = value * k)
  def addTag(t: String): Data790 = copy(tags = t :: tags)
  def put(k: String, v: String): Data790 = copy(meta = meta.updated(k, v))
  def merge(other: Data790): Data790 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data790 {
  given Ordering[Data790] = Ordering.by(_.id)
  def empty: Data790 = Data790(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data790 =
    Data790(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data790] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
