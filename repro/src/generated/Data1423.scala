package generated

final case class Data1423(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1423 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1423 = copy(value = value * k)
  def addTag(t: String): Data1423 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1423 = copy(meta = meta.updated(k, v))
  def merge(other: Data1423): Data1423 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1423 {
  given Ordering[Data1423] = Ordering.by(_.id)
  def empty: Data1423 = Data1423(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1423 =
    Data1423(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1423] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
