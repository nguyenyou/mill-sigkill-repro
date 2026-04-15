package generated

final case class Data973(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data973 = copy(name = name.toUpperCase)
  def scale(k: Double): Data973 = copy(value = value * k)
  def addTag(t: String): Data973 = copy(tags = t :: tags)
  def put(k: String, v: String): Data973 = copy(meta = meta.updated(k, v))
  def merge(other: Data973): Data973 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data973 {
  given Ordering[Data973] = Ordering.by(_.id)
  def empty: Data973 = Data973(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data973 =
    Data973(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data973] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
