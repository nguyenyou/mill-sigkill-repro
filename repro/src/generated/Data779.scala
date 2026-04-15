package generated

final case class Data779(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data779 = copy(name = name.toUpperCase)
  def scale(k: Double): Data779 = copy(value = value * k)
  def addTag(t: String): Data779 = copy(tags = t :: tags)
  def put(k: String, v: String): Data779 = copy(meta = meta.updated(k, v))
  def merge(other: Data779): Data779 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data779 {
  given Ordering[Data779] = Ordering.by(_.id)
  def empty: Data779 = Data779(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data779 =
    Data779(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data779] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
