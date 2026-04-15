package generated

final case class Data286(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data286 = copy(name = name.toUpperCase)
  def scale(k: Double): Data286 = copy(value = value * k)
  def addTag(t: String): Data286 = copy(tags = t :: tags)
  def put(k: String, v: String): Data286 = copy(meta = meta.updated(k, v))
  def merge(other: Data286): Data286 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data286 {
  given Ordering[Data286] = Ordering.by(_.id)
  def empty: Data286 = Data286(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data286 =
    Data286(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data286] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
