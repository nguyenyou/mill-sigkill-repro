package generated

final case class Data547(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data547 = copy(name = name.toUpperCase)
  def scale(k: Double): Data547 = copy(value = value * k)
  def addTag(t: String): Data547 = copy(tags = t :: tags)
  def put(k: String, v: String): Data547 = copy(meta = meta.updated(k, v))
  def merge(other: Data547): Data547 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data547 {
  given Ordering[Data547] = Ordering.by(_.id)
  def empty: Data547 = Data547(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data547 =
    Data547(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data547] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
