package generated

final case class Data952(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data952 = copy(name = name.toUpperCase)
  def scale(k: Double): Data952 = copy(value = value * k)
  def addTag(t: String): Data952 = copy(tags = t :: tags)
  def put(k: String, v: String): Data952 = copy(meta = meta.updated(k, v))
  def merge(other: Data952): Data952 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data952 {
  given Ordering[Data952] = Ordering.by(_.id)
  def empty: Data952 = Data952(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data952 =
    Data952(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data952] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
