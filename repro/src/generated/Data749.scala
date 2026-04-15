package generated

final case class Data749(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data749 = copy(name = name.toUpperCase)
  def scale(k: Double): Data749 = copy(value = value * k)
  def addTag(t: String): Data749 = copy(tags = t :: tags)
  def put(k: String, v: String): Data749 = copy(meta = meta.updated(k, v))
  def merge(other: Data749): Data749 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data749 {
  given Ordering[Data749] = Ordering.by(_.id)
  def empty: Data749 = Data749(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data749 =
    Data749(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data749] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
