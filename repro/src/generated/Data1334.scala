package generated

final case class Data1334(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1334 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1334 = copy(value = value * k)
  def addTag(t: String): Data1334 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1334 = copy(meta = meta.updated(k, v))
  def merge(other: Data1334): Data1334 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1334 {
  given Ordering[Data1334] = Ordering.by(_.id)
  def empty: Data1334 = Data1334(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1334 =
    Data1334(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1334] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
