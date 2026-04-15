package generated

final case class Data709(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data709 = copy(name = name.toUpperCase)
  def scale(k: Double): Data709 = copy(value = value * k)
  def addTag(t: String): Data709 = copy(tags = t :: tags)
  def put(k: String, v: String): Data709 = copy(meta = meta.updated(k, v))
  def merge(other: Data709): Data709 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data709 {
  given Ordering[Data709] = Ordering.by(_.id)
  def empty: Data709 = Data709(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data709 =
    Data709(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data709] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
