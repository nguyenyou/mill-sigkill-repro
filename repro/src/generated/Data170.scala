package generated

final case class Data170(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data170 = copy(name = name.toUpperCase)
  def scale(k: Double): Data170 = copy(value = value * k)
  def addTag(t: String): Data170 = copy(tags = t :: tags)
  def put(k: String, v: String): Data170 = copy(meta = meta.updated(k, v))
  def merge(other: Data170): Data170 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data170 {
  given Ordering[Data170] = Ordering.by(_.id)
  def empty: Data170 = Data170(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data170 =
    Data170(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data170] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
