package generated

final case class Data1484(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1484 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1484 = copy(value = value * k)
  def addTag(t: String): Data1484 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1484 = copy(meta = meta.updated(k, v))
  def merge(other: Data1484): Data1484 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1484 {
  given Ordering[Data1484] = Ordering.by(_.id)
  def empty: Data1484 = Data1484(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1484 =
    Data1484(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1484] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
