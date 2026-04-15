package generated

final case class Data625(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data625 = copy(name = name.toUpperCase)
  def scale(k: Double): Data625 = copy(value = value * k)
  def addTag(t: String): Data625 = copy(tags = t :: tags)
  def put(k: String, v: String): Data625 = copy(meta = meta.updated(k, v))
  def merge(other: Data625): Data625 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data625 {
  given Ordering[Data625] = Ordering.by(_.id)
  def empty: Data625 = Data625(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data625 =
    Data625(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data625] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
