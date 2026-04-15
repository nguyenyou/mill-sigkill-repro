package generated

final case class Data700(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data700 = copy(name = name.toUpperCase)
  def scale(k: Double): Data700 = copy(value = value * k)
  def addTag(t: String): Data700 = copy(tags = t :: tags)
  def put(k: String, v: String): Data700 = copy(meta = meta.updated(k, v))
  def merge(other: Data700): Data700 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data700 {
  given Ordering[Data700] = Ordering.by(_.id)
  def empty: Data700 = Data700(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data700 =
    Data700(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data700] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
