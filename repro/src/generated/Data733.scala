package generated

final case class Data733(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data733 = copy(name = name.toUpperCase)
  def scale(k: Double): Data733 = copy(value = value * k)
  def addTag(t: String): Data733 = copy(tags = t :: tags)
  def put(k: String, v: String): Data733 = copy(meta = meta.updated(k, v))
  def merge(other: Data733): Data733 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data733 {
  given Ordering[Data733] = Ordering.by(_.id)
  def empty: Data733 = Data733(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data733 =
    Data733(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data733] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
