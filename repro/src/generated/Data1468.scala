package generated

final case class Data1468(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1468 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1468 = copy(value = value * k)
  def addTag(t: String): Data1468 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1468 = copy(meta = meta.updated(k, v))
  def merge(other: Data1468): Data1468 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1468 {
  given Ordering[Data1468] = Ordering.by(_.id)
  def empty: Data1468 = Data1468(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1468 =
    Data1468(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1468] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
