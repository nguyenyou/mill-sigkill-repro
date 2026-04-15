package generated

final case class Data609(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data609 = copy(name = name.toUpperCase)
  def scale(k: Double): Data609 = copy(value = value * k)
  def addTag(t: String): Data609 = copy(tags = t :: tags)
  def put(k: String, v: String): Data609 = copy(meta = meta.updated(k, v))
  def merge(other: Data609): Data609 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data609 {
  given Ordering[Data609] = Ordering.by(_.id)
  def empty: Data609 = Data609(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data609 =
    Data609(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data609] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
