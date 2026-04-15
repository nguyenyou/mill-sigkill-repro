package generated

final case class Data984(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data984 = copy(name = name.toUpperCase)
  def scale(k: Double): Data984 = copy(value = value * k)
  def addTag(t: String): Data984 = copy(tags = t :: tags)
  def put(k: String, v: String): Data984 = copy(meta = meta.updated(k, v))
  def merge(other: Data984): Data984 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data984 {
  given Ordering[Data984] = Ordering.by(_.id)
  def empty: Data984 = Data984(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data984 =
    Data984(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data984] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
