package generated

final case class Data921(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data921 = copy(name = name.toUpperCase)
  def scale(k: Double): Data921 = copy(value = value * k)
  def addTag(t: String): Data921 = copy(tags = t :: tags)
  def put(k: String, v: String): Data921 = copy(meta = meta.updated(k, v))
  def merge(other: Data921): Data921 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data921 {
  given Ordering[Data921] = Ordering.by(_.id)
  def empty: Data921 = Data921(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data921 =
    Data921(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data921] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
