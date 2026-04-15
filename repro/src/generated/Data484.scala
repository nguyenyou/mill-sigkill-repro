package generated

final case class Data484(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data484 = copy(name = name.toUpperCase)
  def scale(k: Double): Data484 = copy(value = value * k)
  def addTag(t: String): Data484 = copy(tags = t :: tags)
  def put(k: String, v: String): Data484 = copy(meta = meta.updated(k, v))
  def merge(other: Data484): Data484 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data484 {
  given Ordering[Data484] = Ordering.by(_.id)
  def empty: Data484 = Data484(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data484 =
    Data484(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data484] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
