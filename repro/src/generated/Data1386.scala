package generated

final case class Data1386(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1386 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1386 = copy(value = value * k)
  def addTag(t: String): Data1386 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1386 = copy(meta = meta.updated(k, v))
  def merge(other: Data1386): Data1386 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1386 {
  given Ordering[Data1386] = Ordering.by(_.id)
  def empty: Data1386 = Data1386(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1386 =
    Data1386(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1386] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
