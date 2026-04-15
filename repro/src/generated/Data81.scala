package generated

final case class Data81(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data81 = copy(name = name.toUpperCase)
  def scale(k: Double): Data81 = copy(value = value * k)
  def addTag(t: String): Data81 = copy(tags = t :: tags)
  def put(k: String, v: String): Data81 = copy(meta = meta.updated(k, v))
  def merge(other: Data81): Data81 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data81 {
  given Ordering[Data81] = Ordering.by(_.id)
  def empty: Data81 = Data81(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data81 =
    Data81(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data81] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
